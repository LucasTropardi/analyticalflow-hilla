import { User } from 'Frontend/models/User';
import { Role } from 'Frontend/models/Role';
import { UserEndpoint, AuthEndpoint } from 'Frontend/generated/endpoints';
import UserDetails from 'Frontend/generated/org/springframework/security/core/userdetails/UserDetails';

export const registerUser = async (nome: string, sobrenome: string, email: string, senha: string): Promise<User> => {
  try {
    const user = await UserEndpoint.save({
      email,
      password: senha,
      name: nome,
      lastname: sobrenome,
      role: Role.USER,
    });
    return user as User;
  } catch (error) {
    let errorMessage = 'Failed to register user';

    if (error instanceof Error) {
      if (error.message.includes("Endpoint 'UserEndpoint' method 'save' execution failure")) {
        errorMessage = 'E-mail já cadastrado';
      } else {
        errorMessage = error.message;
      }
    }

    throw new Error(errorMessage);
  }
};

export const loginUser = async (email: string, password: string): Promise<UserDetails> => {
  const response = await fetch('/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ username: email, password }),
    credentials: 'include',
  });

  if (!response.ok) {
    throw new Error('Failed to login');
  }

  return response.json();
};

export const getCurrentUser = async (): Promise<UserDetails | null> => {
  return AuthEndpoint.getCurrentUser();
};
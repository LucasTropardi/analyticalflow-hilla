import { User } from 'Frontend/models/User';
import { Role } from 'Frontend/models/Role';
import { UserEndpoint } from 'Frontend/generated/endpoints';

export const registerUser = async (nome: string, sobrenome: string, email: string, senha: string): Promise<User> => {
  try {
    const user = await UserEndpoint.save({
      name: nome,
      lastname: sobrenome,
      email,
      password: senha,
      role: Role.USER,
    });
    return user as User;
  } catch (error) {
    let errorMessage = 'Failed to register user';

    if (error instanceof Error) {
      // personalizar mensagens de erros
      if (error.message.includes("Endpoint 'UserEndpoint' method 'save' execution failure")) {
        errorMessage = 'E-mail já cadastrado';
      } else {
        errorMessage = error.message;
      }
    }

    throw new Error(errorMessage);
  }
};
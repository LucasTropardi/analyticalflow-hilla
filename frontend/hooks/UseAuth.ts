import { useEffect, useState } from 'react';
import * as AuthService from '../service/AuthService';
import { User } from 'Frontend/models/User';
import UserDetails from 'Frontend/generated/org/springframework/security/core/userdetails/UserDetails';

export const useAuth = () => {
  const [user, setUser] = useState<UserDetails | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [successMessage, setSuccessMessage] = useState<string | null>(null);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const currentUser = await AuthService.getCurrentUser();
        setUser(currentUser);
      } catch (err) {
        console.error(err);
      }
    };
    fetchUser();
  }, []);

  const register = async (nome: string, sobrenome: string, email: string, senha: string) => {
    try {
      const userData = await AuthService.registerUser(nome, sobrenome, email, senha);
      setUser({
        username: userData.email,
        password: '',
        authorities: [{ authority: userData.role }],
      } as UserDetails);
      setError(null);
      setSuccessMessage('Cadastro realizado com sucesso!');
    } catch (err) {
      if (err instanceof Error) {
        setError(err.message);
      } else {
        setError('An unknown error occurred');
      }
      setSuccessMessage(null);
    }
  };

  const login = async (email: string, password: string) => {
    try {
      const userData = await AuthService.loginUser(email, password);
      setUser(userData);
      setError(null);
      setSuccessMessage('Login realizado com sucesso!');
    } catch (err) {
      if (err instanceof Error) {
        setError(err.message);
      } else {
        setError('An unknown error occurred');
      }
      setSuccessMessage(null);
    }
  };

  const clearMessages = () => {
    setError(null);
    setSuccessMessage(null);
  };

  return {
    user,
    error,
    successMessage,
    register,
    login,
    clearMessages,
  };
};
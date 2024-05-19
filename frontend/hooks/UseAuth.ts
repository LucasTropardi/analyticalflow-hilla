import { useState } from 'react';
import * as AuthService from '../service/AuthService';
import { User } from 'Frontend/models/User';

export const useAuth = () => {
  const [user, setUser] = useState<User | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [successMessage, setSuccessMessage] = useState<string | null>(null);

  const register = async (nome: string, sobrenome: string, email: string, senha: string) => {
    try {
      const userData = await AuthService.registerUser(nome, sobrenome, email, senha);
      setUser(userData);
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

  const clearMessages = () => {
    setError(null);
    setSuccessMessage(null);
  };

  return {
    user,
    error,
    successMessage,
    register,
    clearMessages,
  };
};
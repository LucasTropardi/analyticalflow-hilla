import React, { useState, useEffect } from 'react';
import { FormLayout } from '@hilla/react-components/FormLayout.js';
import { PasswordField } from '@hilla/react-components/PasswordField.js';
import { TextField } from '@hilla/react-components/TextField.js';
import { Button } from '@hilla/react-components/Button.js';
import { Link, useNavigate } from 'react-router-dom';
import { Notification } from '@hilla/react-components/Notification.js';
import { HorizontalLayout } from '@hilla/react-components/HorizontalLayout.js';

import { useAuth } from 'Frontend/hooks/UseAuth'; // Ajuste o caminho conforme necessário

const RegisterView: React.FC = () => {
  const navigate = useNavigate();
  const { register, error, successMessage, clearMessages } = useAuth();
  const [nome, setNome] = useState('');
  const [sobrenome, setSobrenome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [confirmarSenha, setConfirmarSenha] = useState('');
  const [notificationOpened, setNotificationOpened] = useState(false);
  const [notificationMessage, setNotificationMessage] = useState('');
  const [notificationTheme, setNotificationTheme] = useState<'error' | 'success'>('error');

  const resetForm = () => {
    setNome('');
    setSobrenome('');
    setEmail('');
    setSenha('');
    setConfirmarSenha('');
  };

  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();

    if (senha !== confirmarSenha) {
      setNotificationMessage('Senhas não coincidem');
      setNotificationTheme('error');
      setNotificationOpened(true);
      return;
    }

    await register(nome, sobrenome, email, senha);
  };

  useEffect(() => {
    if (successMessage) {
      clearMessages();
      resetForm();
      navigate('/login', { state: { message: successMessage, messageType: 'success' } });
    }
    if (error) {
      setNotificationMessage(error);
      setNotificationTheme('error');
      setNotificationOpened(true);
      clearMessages();
    }
  }, [successMessage, error, clearMessages, navigate]);

  const responsiveSteps = [
    { minWidth: '0', columns: 1 },
    { minWidth: '500px', columns: 2 },
  ];

  return (
    <main className="py-8">
      <section className="max-w-8xl mx-auto sm:px-6 lg:px-8 space-y-6">
        <section className="bg-gray-300 shadow sm:rounded-lg p-1.5">
          <section className="bg-gray-400 shadow sm:rounded-lg p-1.5">
            <section className="p-4 sm:p-8 bg-white sm:rounded-lg">
              <form onSubmit={handleSubmit}>
                <FormLayout responsiveSteps={responsiveSteps}>
                  <TextField label="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
                  <TextField label="Sobrenome" value={sobrenome} onChange={(e) => setSobrenome(e.target.value)} />
                  <TextField {...{ colspan: 2 }} label="E-mail" value={email} onChange={(e) => setEmail(e.target.value)} />
                  <PasswordField label="Senha" value={senha} onChange={(e) => setSenha(e.target.value)} />
                  <PasswordField label="Confirme a senha" value={confirmarSenha} onChange={(e) => setConfirmarSenha(e.target.value)} />
                  <section className="flex items-center justify-between mt-6" {...{ colspan: 2 }}>
                    <Link to="/login" className="mt-4 font-medium text-blue-600 hover:underline">
                      Já possui cadastro?
                    </Link>
                    <Button onClick={handleSubmit} className="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-medium rounded-lg text-sm px-12 py-2.5 text-center me-2 mb-2 mt-6">
                      Cadastre-se
                    </Button>
                  </section>
                </FormLayout>
              </form>
            </section>
          </section>
        </section>
      </section>

      <Notification
        theme={notificationTheme}
        duration={5000}
        position="top-end"
        opened={notificationOpened}
        onOpenedChanged={(e) => setNotificationOpened(e.detail.value)}
      >
        <HorizontalLayout theme="spacing" style={{ alignItems: 'center' }}>
          <div>{notificationMessage}</div>
          <Button
            theme="tertiary-inline"
            onClick={() => setNotificationOpened(false)}
            aria-label="Close"
          >
            <i className="fa-solid fa-xmark"></i>
          </Button>
        </HorizontalLayout>
      </Notification>
    </main>
  );
}

export default RegisterView;
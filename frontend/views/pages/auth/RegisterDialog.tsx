import React, { useEffect, useState } from 'react';
import { Dialog } from '@hilla/react-components/Dialog.js';
import { FormLayout } from '@hilla/react-components/FormLayout.js';
import { PasswordField } from '@hilla/react-components/PasswordField.js';
import { TextField } from '@hilla/react-components/TextField.js';
import { Button } from '@hilla/react-components/Button.js';
import { useAuth } from 'Frontend/hooks/UseAuth';
import { Notification } from '@hilla/react-components/Notification.js';
import { HorizontalLayout } from '@hilla/react-components/HorizontalLayout.js';
import { Icon } from '@hilla/react-components/Icon.js';

const RegisterDialog: React.FC<{ isOpen: boolean, onClose: () => void }> = ({ isOpen, onClose }) => {
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

  useEffect(() => {
    if (successMessage) {
      setNotificationMessage(successMessage);
      setNotificationTheme('success');
      setNotificationOpened(true);
      clearMessages();
      resetForm();
      onClose();
    }
    if (error) {
      setNotificationMessage(error);
      setNotificationTheme('error');
      setNotificationOpened(true);
      clearMessages();
    }
  }, [successMessage, error, onClose, clearMessages]);

  const handleSubmit = async () => {
    if (senha !== confirmarSenha) {
      setNotificationMessage('Senhas não coincidem');
      setNotificationTheme('error');
      setNotificationOpened(true);
      return;
    }

    await register(nome, sobrenome, email, senha);
  };

  return (
    <>
      <Dialog opened={isOpen} onOpenedChanged={({ detail: { value } }) => !value && onClose()} aria-label="Register Dialog">
        <div className="p-4">
          <h2 className="text-lg font-semibold mb-4">Cadastre-se</h2>
          <form onSubmit={(e) => e.preventDefault()} className="space-y-4">
            <div className="grid grid-cols-1 gap-4 sm:grid-cols-2">
              <TextField label="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
              <TextField label="Sobrenome" value={sobrenome} onChange={(e) => setSobrenome(e.target.value)} />
              <TextField label="E-mail" value={email} onChange={(e) => setEmail(e.target.value)} className="col-span-2" />
              <PasswordField label="Senha" value={senha} onChange={(e) => setSenha(e.target.value)} />
              <PasswordField label="Confirmar senha" value={confirmarSenha} onChange={(e) => setConfirmarSenha(e.target.value)} />
            </div>
            <div className="flex justify-end mt-4">
              <Button onClick={onClose} className="mr-2">Cancelar</Button>
              <Button onClick={handleSubmit} theme="primary">Salvar</Button>
            </div>
          </form>
        </div>
      </Dialog>

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
    </>
  );
}

export default RegisterDialog;
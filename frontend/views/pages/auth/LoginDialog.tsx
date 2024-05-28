import React, { useState } from 'react';
import { Dialog } from '@hilla/react-components/Dialog.js';
import { FormLayout } from '@hilla/react-components/FormLayout.js';
import { PasswordField } from '@hilla/react-components/PasswordField.js';
import { TextField } from '@hilla/react-components/TextField.js';
import { Button } from '@hilla/react-components/Button.js';
import { useAuth } from 'Frontend/hooks/UseAuth';
import { Notification } from '@hilla/react-components/Notification.js';
import { HorizontalLayout } from '@hilla/react-components/HorizontalLayout.js';

const LoginDialog: React.FC<{ isOpen: boolean, onClose: () => void }> = ({ isOpen, onClose }) => {
  const { login, error } = useAuth();
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [notificationOpened, setNotificationOpened] = useState(false);
  const [notificationMessage, setNotificationMessage] = useState('');

  const handleSubmit = async () => {
    await login(email, senha);
    if (!error) {
      setNotificationMessage('Login realizado com sucesso!');
      setNotificationOpened(true);
      onClose();
    } else {
      setNotificationMessage(error);
      setNotificationOpened(true);
    }
  };

  return (
    <>
      <Dialog opened={isOpen} onOpenedChanged={({ detail: { value } }) => !value && onClose()} aria-label="Login Dialog">
        <div className="p-4">
          <h2 className="text-lg font-semibold mb-4">Login</h2>
          <form onSubmit={(e) => e.preventDefault()} className="space-y-4">
            <div className="grid grid-cols-1 gap-4 sm:grid-cols-2">
              <TextField label="E-mail" value={email} onChange={(e) => setEmail(e.target.value)} className="col-span-2" />
              <PasswordField label="Senha" value={senha} onChange={(e) => setSenha(e.target.value)} className="col-span-2" />
            </div>
            <div className="flex justify-end mt-4">
              <Button onClick={onClose} className="mr-2">Cancelar</Button>
              <Button onClick={handleSubmit} theme="primary">Login</Button>
            </div>
          </form>
        </div>
      </Dialog>

      <Notification
        theme={error ? 'error' : 'success'}
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
};

export default LoginDialog;
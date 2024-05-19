import React, { useState } from 'react';
import { Dialog } from '@hilla/react-components/Dialog.js';
import { FormLayout } from '@hilla/react-components/FormLayout.js';
import { PasswordField } from '@hilla/react-components/PasswordField.js';
import { TextField } from '@hilla/react-components/TextField.js';
import { Button } from '@hilla/react-components/Button.js';

const LoginDialog: React.FC<{ isOpen: boolean, onClose: () => void }> = ({ isOpen, onClose }) => {
  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    // Logic to handle form submission will go here
    console.log('Login form submitted');
  };

  return (
    <Dialog opened={isOpen} onOpenedChanged={({ detail: { value } }) => !value && onClose()} aria-label="Login Dialog">
      <div className="p-4">
        <h2 className="text-lg font-semibold mb-4">Login</h2>
        <form onSubmit={handleSubmit}>
          <FormLayout>
            <TextField label="E-mail" />
            <PasswordField label="Senha" />
            <div className="flex justify-end mt-4">
              <Button onClick={onClose} className="mr-2">Cancelar</Button>
              <Button theme="primary">Entrar</Button>
            </div>
          </FormLayout>
        </form>
      </div>
    </Dialog>
  );
}

export default LoginDialog;
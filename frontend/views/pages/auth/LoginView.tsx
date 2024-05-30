import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import { FormLayout } from '@hilla/react-components/FormLayout.js';
import { PasswordField } from '@hilla/react-components/PasswordField.js';
import { TextField } from '@hilla/react-components/TextField.js';
import { Button } from '@hilla/react-components/Button.js';
import { Link } from 'react-router-dom';
import { Notification } from '@hilla/react-components/Notification.js';
import { HorizontalLayout } from '@hilla/react-components/HorizontalLayout.js';

const LoginView: React.FC = () => {
  const location = useLocation();
  const [notificationOpened, setNotificationOpened] = useState(false);
  const [notificationMessage, setNotificationMessage] = useState('');
  const [notificationTheme, setNotificationTheme] = useState<'error' | 'success'>('success');

  useEffect(() => {
    if (location.state && location.state.message) {
      setNotificationMessage(location.state.message);
      setNotificationTheme(location.state.messageType || 'success');
      setNotificationOpened(true);
    }
  }, [location.state]);

  const responsiveSteps = [
    { minWidth: '0', columns: 1 },
    { minWidth: '500px', columns: 2 },
  ];

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    // Logic to handle form submission will go here
    console.log('Form submitted');
  };

  return (
    <main className="py-8">
      <section className="max-w-2xl mx-auto sm:px-6 lg:px-8 space-y-6">
        <section className="bg-gray-300 shadow sm:rounded-lg p-1.5">
          <section className="bg-gray-400 shadow sm:rounded-lg p-1.5">
            <section className="p-4 sm:p-8 bg-white sm:rounded-lg">
              <form onSubmit={handleSubmit}>
                <FormLayout responsiveSteps={responsiveSteps}>
                  <TextField label="E-mail" {...{ colspan: 2 }} />
                  <PasswordField label="Senha" {...{ colspan: 2 }} />
                  <section className="flex items-center justify-between mt-6" {...{ colspan: 2 }}>
                    <Link to="/register" className="mt-4 font-medium text-blue-600 hover:underline">
                      Não possui cadastro?
                    </Link>
                    <Button className="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-medium rounded-lg text-sm px-16 py-2.5 text-center me-2 mb-2 mt-6">
                      Entrar
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

export default LoginView;

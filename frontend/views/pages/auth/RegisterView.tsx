import { FormLayout } from '@hilla/react-components/FormLayout.js';
import { PasswordField } from '@hilla/react-components/PasswordField.js';
import { TextField } from '@hilla/react-components/TextField.js';
import React from 'react';
import { Button } from '@hilla/react-components/Button.js';
import { Link } from 'react-router-dom';

const RegisterView: React.FC = () => {
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
    <div className="py-8">
      <div className="max-w-8xl mx-auto sm:px-6 lg:px-8 space-y-6">
        <div className="bg-gray-300 shadow sm:rounded-lg p-1.5">
          <div className="bg-gray-400 shadow sm:rounded-lg p-1.5">
            <div className="p-4 sm:p-8 bg-white sm:rounded-lg">
              <form onSubmit={handleSubmit}>
                <FormLayout responsiveSteps={responsiveSteps}>
                  <TextField label="Nome" />
                  <TextField label="Sobrenome" />
                  <TextField {...{ colspan: 2 }} label="E-mail" />
                  <PasswordField label="Senha" />
                  <PasswordField label="Confirme a senha" />
                  <div className="flex items-center justify-between mt-6" {...{ colspan: 2 }}> 
                    <Link to="/login" className="mt-4 font-medium text-blue-600  hover:underline">
                      Já possui cadastro?
                    </Link>
                    <Button className="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 mt-6">
                      Cadastre-se
                    </Button>
                  </div>
                </FormLayout>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default RegisterView;
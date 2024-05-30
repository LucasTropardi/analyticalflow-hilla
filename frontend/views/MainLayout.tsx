import { AppLayout } from '@hilla/react-components/AppLayout.js';
import { DrawerToggle } from '@hilla/react-components/DrawerToggle.js';
import { useRouteMetadata } from 'Frontend/util/routing.js';
import { Suspense, useEffect, useState } from 'react';
import { NavLink, Outlet, useNavigate } from 'react-router-dom';
import { Button } from '@hilla/react-components/Button.js';
import LoginDialog from './pages/auth/LoginDialog'; 
import RegisterDialog from './pages/auth/RegisterDialog'; 

const navLinkClasses = ({ isActive }: { isActive: boolean }) => {
  return `block rounded-m p-s ${isActive ? 'bg-primary-10 text-primary' : 'text-body'}`;
};

export default function MainLayout() {
  const currentTitle = useRouteMetadata()?.title ?? 'My App';
  const navigate = useNavigate();

  useEffect(() => {
    document.title = currentTitle;
  }, [currentTitle]);

  const handleRegisterClick = () => {
    navigate('/register'); 
  };

  const handleLoginClick = () => {
    navigate('/login');
  };

  return (
    <AppLayout primarySection="drawer">
      <section slot="drawer" className="flex flex-col justify-between h-full p-m">
        <header className="flex flex-col gap-m">
          <span className="font-semibold text-l">My App</span>
          <nav>
            <NavLink className={navLinkClasses} to="/">
              Home
            </NavLink>
          </nav>
        </header>
      </section>

      <section slot="navbar" className="navbar">
        <section className="left-section">
          <DrawerToggle aria-label="Menu toggle"></DrawerToggle>
          <h1 className="text-l m-0">{currentTitle}</h1>
        </section>
        <section className="right-section">
          <section className="inline-flex rounded-md shadow-sm" role="group">
            <Button theme='icon' onClick={handleLoginClick} className="px-4 py-2 text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-s-lg hover:bg-gray-100 hover:text-blue-700 focus:z-10 focus:ring-2 focus:ring-blue-700 focus:text-blue-700">
              Entrar
            </Button>
            <Button theme='icon' onClick={handleRegisterClick} className="px-4 py-2 text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-e-lg hover:bg-gray-100 hover:text-blue-700 focus:z-10 focus:ring-2 focus:ring-blue-700 focus:text-blue-700">
              <i className="fa-solid fa-user-plus"></i>
            </Button>
          </section>
        </section>
      </section>

      <Suspense>
        <Outlet />
      </Suspense>
      
    </AppLayout>
  );
}

function setIdRegisterDialogOpen(arg0: boolean) {
  throw new Error('Function not implemented.');
}

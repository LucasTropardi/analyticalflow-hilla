import MainLayout from 'Frontend/views/MainLayout';
import { createBrowserRouter, RouteObject } from 'react-router-dom';
import HomeView from './views/pages/Home';
import RegisterView from './views/pages/auth/RegisterView';
import LoginView from './views/pages/auth/LoginView';


const routing = [
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/', element: <HomeView />, handle: { title: 'Home', requiresLogin: true } },
      { path: '/register', element: <RegisterView />, handle: { title: 'Cadastre-se' } },
      { path: '/login', element: <LoginView />, handle: { title: 'Entrar' } },
    ],
  },
] as RouteObject[];

export const routes = routing;
export default createBrowserRouter(routes);
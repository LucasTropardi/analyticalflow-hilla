import MainLayout from 'Frontend/views/MainLayout.js';
import { createBrowserRouter, RouteObject } from 'react-router-dom';
import HomeView from './views/pages/Home';
import RegisterView from './views/pages/auth/RegisterView';

const routing = [
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/', element: <HomeView />, handle: { title: 'Home' } },

    ],
  },
] as RouteObject[];

export const routes = routing;
export default createBrowserRouter(routes);
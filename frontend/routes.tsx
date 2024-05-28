import MainLayout from 'Frontend/views/MainLayout';
import { createBrowserRouter, RouteObject } from 'react-router-dom';
import HomeView from './views/pages/Home';

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
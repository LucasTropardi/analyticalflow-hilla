
import { useState } from 'react';

export default function HomeView() {
  const [name, setName] = useState('');

  return (
    <>
      <div>
        <h1>Home Page</h1>
        <p>Welcome to the Home Page!</p>
      </div>
    </>
  );
}

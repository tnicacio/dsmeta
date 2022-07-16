import 'react-toastify/dist/ReactToastify.css';

import { ToastContainer } from 'react-toastify';

import Header from './components/Header';
import MainContainer from './components/MainContainer';

function App() {
  return (
    <>
      <ToastContainer />
      <Header />
      <MainContainer />
    </>
  );
}

export default App;

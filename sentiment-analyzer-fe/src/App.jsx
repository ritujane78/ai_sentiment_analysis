import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <div className="container mx-auto p-4">
      <h1 className='text-2xl font-bold mb-4'>Sentiment Feedback Analyzer</h1>
      <form className='mb-4'> 
        <textarea className='w-full p-2 border rounded' placeholder='Enter the feedback here...' rows="4"></textarea>
        <button type='submit' 
        className='px-4 py-4 my-5 bg-blue-500 text-white rounded'>
        Submit Feedback
        </button>
      </form>
      <h2 className='text-xl font-semibold mb-2'>Feedback History</h2>
      <table className='table-auto w-full text-sm text-left text-gray-500'>
        <thead className='text-gray-700 bg-gray-50' >
          <tr>
            <th>Feedback</th>
            <th>Score</th>
            <th>Sentiment</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Feedback Feedback Feedback</td>
            <td>0.8</td>
            <td>Positive</td>
          </tr>
        </tbody>
      </table>
    </div>
    </>
  )
}

export default App

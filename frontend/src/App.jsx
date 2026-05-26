import { useEffect, useState } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const [articles, setArticles] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  useEffect(() => {
    axios
      .get('/api/news')
      .then((res) => setArticles(res.data))
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <main className="news"><p className="status">Loading…</p></main>
  if (error)   return <main className="news"><p className="status">Error: {error}</p></main>

  return (
    <main className="news">
      <h1>Top Headlines</h1>
      <ul className="articles">
        {articles.map((a, i) => (
          <li key={a.url ?? i} className="article">
            <a href={a.url} target="_blank" rel="noopener noreferrer">
              <h2>{a.title}</h2>
            </a>
            {a.description && <p className="desc">{a.description}</p>}
            <p className="meta">
              {a.source?.name && <span>{a.source.name}</span>}
              {a.author && <span> · {a.author}</span>}
              {a.publishedAt && (
                <span> · {new Date(a.publishedAt).toLocaleDateString()}</span>
              )}
            </p>
          </li>
        ))}
      </ul>
    </main>
  )
}

export default App
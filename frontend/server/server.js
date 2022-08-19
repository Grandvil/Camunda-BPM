var cors = require('cors')
const bodyParser = require('body-parser')
const express = require('express');
const path = require('path');
const axios = require('axios');

const app = express();

app.use(cors({
  origin: ["http://localhost:8080"],
  credentials: true,
}));

app.use(bodyParser.json())
const port = 3000;


app.get('/', function(req, res) {
  res.sendFile(path.join(__dirname, '/index.html'));
});

app.post('/test', async function(req, res) {
  data = await axios.post('http://localhost:8080/engine-rest/process-definition/key/Process_1g4uasv/start', req.body).then(res => res.data) //data.id
  console.log(data.id);
  res.send(data);
});

app.listen(port);
console.log('Server started at http://localhost:' + port);
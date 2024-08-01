import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // Adjust the base URL if necessary
});

export const createTask = (task) => api.post('/tasks', task);

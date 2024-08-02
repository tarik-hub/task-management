import React, { useState } from 'react';
import { createTask } from '../services/api';

const CreateTask = () => {
  const [task, setTask] = useState({
    title: '',
    description: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setTask((prevTask) => ({
      ...prevTask,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createTask(task);
      alert('Task created successfully !');
    } catch (error) {
      alert('Error : Can't create task');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Title:</label>
        <input
          type="text"
          name="title"
          value={task.title}
          onChange={handleChange}
        />
      </div>
      <div>
        <label>Description:</label>
        <input
          type="text"
          name="description"
          value={task.description}
          onChange={handleChange}
        />
      </div>
      <button type="submit">Create Task</button>
    </form>
  );
};

export default CreateTask;

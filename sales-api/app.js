import express from 'express';

const app = express();
const env = process.env;
const PORT = env.PORT || 8082;

app.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
})
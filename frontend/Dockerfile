# Use an official Node.js image to build the project
FROM node:14 AS build

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json
COPY frontend/package.json frontend/package-lock.json ./

# Install dependencies
RUN npm install

# Copy the rest of the frontend code
COPY frontend ./frontend

# Build the React application
RUN npm run build

# Use an Nginx image to serve the built files
FROM nginx:alpine

# Copy the built files from the build stage
COPY --from=build /app/frontend/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]

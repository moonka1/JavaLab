# JavaLab

Async Processing and Error Handling (Java)

# Overview

This project demonstrates basic asynchronous processing and error handling using CompletableFuture in Java.

# Functionality
	•	Asynchronous data execution using a separate thread
	•	Data transformation after successful execution
	•	Error handling using handle()
	•	Returning a fallback value in case of failure

# How it works

The application starts an asynchronous task that simulates data loading.
If the operation is successful, the data is modified and printed.
If an error occurs, it is handled without crashing the program, and a backup value is returned.

# Key Concepts
	•	Non-blocking execution with CompletableFuture
	•	Combined result and error handling using handle()
	•	Thread management with ExecutorService

# Result

The program continues working even if an error occurs, ensuring stability and predictable output.

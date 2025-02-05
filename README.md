<h1 align="center"> Number-API 💘</h1>

<p align="center">
  A simple <strong>Spring Boot</strong>-based public API to classify a number and retrieve interesting mathematical properties along with a fun fact.
</p>

<h2>✨ Features</h2>

<ul>
  <li>🔢 Accepts a number as a query parameter.</li>
  <li>❓ Determines if the number is prime and perfect.</li>
  <li>💡 Checks if the number is an Armstrong number.</li>
  <li>⚖️ Classifies the number as <strong>odd</strong> or <strong>even</strong>.</li>
  <li>🔢 Calculates the sum of the number’s digits.</li>
  <li>🤩 Fetches a fun fact about the number from the Numbers API.</li>
</ul>

<h2> 🔗 Where Do You Get This Info? </h2> 

<h3>📌 API Endpoint</h3>
<p>Just send a <code>GET</code> request to:</p>

<pre><code>https://number-api-8jls.onrender.com/api/classify-number?number=371</code></pre>

<h3>📌 Example Response</h3>

<img src="https://github.com/user-attachments/assets/39607111-bd68-4420-8bfc-e8c7016c061d79145cc6" alt="API Response Preview">

📌 <strong>JSON Response Format</strong>  
<pre>
{
  "number": 371,
  "is_prime": false,
  "is_perfect": false,
  "properties": ["armstrong", "odd"],
  "digit_sum": 11,
  "fun_fact": "371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371"
}
</pre>
<p>All responses are returned in JSON format. In case of an invalid input, a 400 Bad Request is returned:</p>

<pre>
{
  "number": "alphabet",
  "error": true
}
</pre>

<h2>🚀 How to Run Locally</h2>

<p>Wanna run this API on your machine? Easy. Follow these steps:</p>

<h3>1️⃣ Clone the Repository</h3>

<pre><code>git clone https://github.com/mazino-ux/Number-API.git
cd Number-API
</code></pre>

<h3>2️⃣ Run It with Maven</h3>

<pre><code>./mvnw spring-boot:run</code></pre>

<p>Boom! The API is now running at:</p>

<a href="http://localhost:8080/api/classify-number?number=371">http://localhost:8080/api/classify-number?number=371</a>

<h3>3️⃣ Build and Run as JAR</h3>

<pre><code>./mvnw clean install
java -jar target/Number-api-0.0.1-SNAPSHOT.jar
</code></pre>

<h2>🌍 Deployment</h2>

<p>This API is live and running on <strong>Render</strong>, so no need to set it up manually.</p>

<h2>⏱️ API Response Time</h2>  
This API is optimized to respond in under <strong>500ms</strong>, ensuring fast performance.  

<h3>🔗 Live API URL:</h3>

<pre><code>https://number-api-8jls.onrender.com/api/classify-number</code></pre>

<h2>🌐 CORS Handling</h2>

<p>CORS is enabled for all origins, meaning any client from anywhere can hit this API without issues. No restrictive nonsense.</p>

<h2>🛠️ Tech Stack</h2>

<ul>
  <li>☕ <strong>Spring Boot</strong> – Java-based framework for rapid API development.</li>
  <li>🚀 <strong>Render</strong> – Hosting platform for seamless deployment.</li>
  <li>🛠️ <strong>Maven</strong> – Dependency management and build tool.</li>
</ul>

<h2>⚡ Why This API?</h2>

<ul>
  <li>⚡ <strong>Fast</strong> – Response time is under <code>500ms</code>.</li>
  <li>🧩 <strong>Minimalistic</strong> – Focused on classifying numbers with essential properties.</li>
  <li>🔗 <strong>Ready-to-use</strong> – Deployed and accessible.</li>
</ul>

<h2>🔗 Back Link</h2>  
Java: <a href="https://hng.tech/hire/java-developers">https://hng.tech/hire/java-developers</a>

# Toy Problems Repository

Goal:

The test reporting is set up so that when you push or merge to main it will show the results
We want to automate the process of adding a new problem, new tests for that problem each day
Future: Also sending a email with the test results.

https://www.hackerrank.com/challenges/new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

https://github.com/MrSankofa/my-toy-problems


you have to make pull requests and seperate branches


This repository contains toy problem implementations and tests for three languages:
- **Java**
- **Python**
- **JavaScript**

## Project Structure
my-toy-problems/ 
├── java/ # Java implementations and tests

├── python/ # Python implementations and tests

├── javascript/ # JavaScript implementations and tests

└── .github/workflows/ # CI configurations


## Running Tests

### Java local tests
```
cd java
mvn test
```
### Python local tests
```
cd python
pip install -r requirements.txt
pytest
```
### Javascript local tests
```
cd javascript
npm install
npm test 
```


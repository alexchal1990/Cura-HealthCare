⭐ Installation & Setup (All Operating Systems)
## 💻 Installation & Setup (Works on Windows, macOS, and Linux)

The CURA Healthcare Automation Framework is fully cross-platform and can be run on **any operating system** as long as Java and Maven are installed.

Follow the steps below:

---

# 📥 1. Download or Clone the Project

### Option A — Download ZIP (Recommended for non-technical users)
1. Go to the repository page  
2. Click **Code → Download ZIP**  
3. Extract the folder anywhere on your computer  

### Option B — Clone using Git (Developers)


git clone https://github.com/alexchal1990/Cura-Healthcare.git


---

# ☕ 2. Install Java (JDK 17+ Required)

### ✔ Windows
- Download from: https://adoptium.net  
- Install  
- Open terminal → run:



java -version


You should see version 17 or above.

### ✔ macOS


brew install openjdk@17


### ✔ Linux (Ubuntu/Debian)


sudo apt install openjdk-17-jdk


---

# 🧱 3. Install Maven (Build Tool)

### ✔ Windows
Download & install from:  
https://maven.apache.org/download.cgi  

Check version:


mvn -version


### ✔ macOS


brew install maven


### ✔ Linux


sudo apt install maven


---

# 🌐 4. No Driver Setup Needed (Automatic in Selenium 4+)

Your framework uses Selenium 4, which includes:  
✔ Built-in driver management  
✔ No need to download ChromeDriver, GeckoDriver, etc  
✔ Works with Chrome, Firefox, Edge on all OS

Selenium automatically handles driver downloads.

---

# ▶️ 5. Run the Test Suite

Inside the project folder:

### Option A — Using IntelliJ/Eclipse/VSCode
- Open project  
- Navigate to `testng.xml`  
- Right-click → **Run As → TestNG Suite**

### Option B — Using Terminal (All OS)


mvn clean test


### Option C — Run only a specific suite

**Smoke:**


mvn clean test -Psmoke


**Regression:**


mvn clean test -Pregression


---

# 📊 6. View the HTML Report

After the test run finishes, open:



reports/ExtentReport.html


This report includes:
- All test results  
- Screenshots for failed tests  
- Timestamps  
- Exceptions  
- Execution details  

Works on **all OS** — simply double-click to open in your browser.

---

# 📸 7. Failed Test Screenshots

Screenshots are automatically saved in:



reports/screenshots/


This makes failure analysis quick and visual.

---

# 🎉 Setup Complete!

You can now:
- Run automated login tests  
- Run booking tests  
- Run end-to-end patient appointment flows  
- Generate HTML reports  
- Collect screenshots on failures  
- Extend the framework with new tests  

This project is ready for real-world QA automation workflows.

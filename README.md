# 🩸 Blood Donation Camp Management System

A robust, console-based **Blood Donation Camp Management System** designed in Java to streamline donor coordination, enforce health compliance rules, and track available blood reserves. This application acts as an agile operational manager to register voluntary donors and quickly connect medical institutions with matching blood profiles.

---

## 📌 Key Features & Program Modules

### 📋 1. Smart Donor Registration
- **Medical Compliance Gate:** Automatically evaluates potential donors based on health rules (Age must be 18–65 years, Weight must be $\ge$ 40 kg).
- **String and Data Cleansing:** Runs verification loops to reject names containing numeric symbols and blocks invalid 10-digit mobile configurations.
- **Custom Calendar Processing:** Houses an internal calendar check loop preventing abnormal date inputs (e.g., cross-references maximum days allowable per month).
- **Auto-Generated Tracking Profiles:** Assigns unique incremental tracking hashes (`Donor_Id` tracking) starting from base reference `135` upon successful completion.

### 🔍 2. Advanced Search & Allocation Engine
- **Multi-Filter Lookup System:** Access data logs instantly by filtering the runtime stack across three custom fields:
  - **By Unique Donor ID**
  - **By Blood Group Category** (A+, O+, B+, AB+, A-, O-, B-, AB-)
  - **By Scheduled Donation Date**
- **Emergency Matching Module:** Allows hospitals or individuals to query available inventories based on emergency classification (Medical Emergency vs. Hospital Storage) to locate active emergency point-of-contact details.

---

## 🛠️ Technical Implementation Details

- **Language & Paradigms:** Java (Object-Oriented Programming, Robust Class Inheritance via `find_search extends Main`).
- **Data Caching & Storage:** Utilizes parallel array architectures (`static String[]`, `long[]`, `double[]`) configured with lookahead boundaries to manage multi-attribute entity relationships at runtime.
- **Input Stream Handling:** Managed entirely via `java.util.Scanner` utilizing selective buffer clearing (`sc.nextLine()`) to eliminate input skipping during text-to-integer transitions.

---

## 🚀 Getting Started

### Prerequisites
Make sure you have the Java Development Kit (JDK 8 or higher) installed on your system.


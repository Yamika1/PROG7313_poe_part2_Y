Budget Bee – PROG7313 Part 3
---------------
Purpose of App
----------------
Our application Budget Bee is a budgeting application which is designed to help users track their expenses and manage their income more effectively as well as to help users improve their management of financial skills. Our application has gamification elements to help motivate users to use the app consistently and improve their financial habits through the use of a simple rewards system to make the app more interactive and user-friendly. The main features of the app are expense entry, category amounts, a rewards system, user goals, a graph to show progress, notification reminders, statement management, expense search and filter

*Expense Entry*
This refers to where users can add a new expense by entering an amount, category, date and a description. This data is then saved to an online Real-Time Database: Firebase.

*Category Amounts*
This screen shows a breakdown of how much the user spends on different expense categories such as groceries or entertainment. It displays the user’s total amount spent, spending in each category, number of transactions in each category and the category they spend the most in.

*Rewards System*
We added a rewards system to give feedback to the user where users earn XP based on the number of expenses recorded and their pending behaviour. The app also includes a level system, progress bar and an in-app credit score. The rewards system checks if the user stays within the range of their user goals and gives bonus XP if they do. Users are also able to view records by filters and have a choice to download statements.

*User Goals*
BudgetBee allows users to define a minimum and maximum spending goal in user goals interface to help them control how much they spend each month.

*Progress Graph*
This refers to a pie chart located in the Category Amounts interface that provides a visual representation to the user of how much money the user spends on different expense categories, such as groceries or entertainment.

*Notification Reminders*
This refers to reminders in the form of notifications that show up at the top of the screen if the logged-in user has not entered their minimum and maximum user goals for the current month, so that they know to keep their spending limited to within that range.

*Statement Management*
This refers to a feature where users can generate and download monthly financial statements that include expense records, dates, categories, descriptions, total spending for the selected period and the option to upload receipt files.

*Expense Search and Filter*
This refers to a feature where users can search through their expense history in the expense search interface using a search bar, filters by week, month, or custom date range, results displayed with date, description, category, and amount.


-----------------
Target Audience
-----------------
BudgetBee was designed for adults with a source of income that need help controlling their spending habits and managing their finances in order to become more financially stable.

-----------------------
Design Considerations
------------------------
*UI/UX Design*
- Login Page
<img width="484" height="1058" alt="image" src="https://github.com/user-attachments/assets/bbccd8c0-255e-472b-a09d-9f74328687c8" />

- Registration Page
<img width="478" height="1064" alt="image" src="https://github.com/user-attachments/assets/9d20dc86-20de-4a9b-9eb8-af82561845e3" />

Budget Bee uses a consistent yellow and black colour scheme with a light orange gradient background throughout the app. The app name is consistently in a bold, black Cherry Bomb font, while the button labels are in a Londrina Solid font. When the app starts, users are greeted with the BudgetBee logo on a light orange background (splash screen), which then opens to the Login screen where users can login with their email and password, however, if the user does not have an account to log into yet then the user can use the register button at the bottom of the screen to go to the registration page, make an account and then come back to login to finally open the app. Both of those pages use a light orange and yellow theme. Users can also select a profile picture from a set of bee-themed images provided by the app to add to their account which gets displayed next to their username on the top right-hand corner of the app when the user is logged in.


-Home Screen
<img width="478" height="1059" alt="image" src="https://github.com/user-attachments/assets/54e46a75-ea5f-43f4-b62b-0e3ee5f94ee3" />

The home screen uses a white background with clearly labelled navigation buttons in yellow and black, linking to:
•	Expense Entry
•	Category Amounts
•	Progress Dashboard
•	Statements

-Expense Entry
<img width="484" height="1059" alt="image" src="https://github.com/user-attachments/assets/defc8872-e19d-405d-88dc-0c8429a1b594" />
The expense entry screen shows yellow card at the top to show the user's total amount spent. Below it, users can select a transaction date, choose a category (which highlights in yellow when selected), and add a description. This screen has a white background to not overwhelm the screen’s appearance.

-Category Amounts
<img width="484" height="1059" alt="image" src="https://github.com/user-attachments/assets/03eca05e-fba6-49a0-8a1b-1b8a2b56da0e" />
The category amount screen shows a yellow card at the top of the screen to show the total amount spent and the top spending category. Below it, categories are listed with icons and amounts. The category amount pie chart can be shown should the user click the blue “Load Graph” button.

-Rewards Page
<img width="484" height="1056" alt="image" src="https://github.com/user-attachments/assets/fcf47f36-33d5-4567-bf4f-423b2308e7ef" />
The rewards screen shows progression cards showing XP earned per objective with a white background to not overwhelm the screen’s appearance. There is also a black card that displays the user's total credit score in yellow text. The user's current level is shown in bold in the top-right of the XP card.

-Statements Page
<img width="478" height="1059" alt="image" src="https://github.com/user-attachments/assets/b2fb2fa0-a497-43ec-b822-46f4d703392e" />
The statements screen displays the current month's period in a card, followed by a list of downloadable monthly statements (yellow download buttons). A yellow upload button at the bottom allows users to attach files.

*Tech Stack*
The app was developed using an IDE known as Android Studios, while using the Kotlin programming language for backend logic and making use of Firebase for a Real-Time database for data and file storage as well as authentication for the login system.


*Database Design*
We used a Firebase Database with a Cost table to store all the data when users create entries for expenses, a Goal table where all costs are recorded, an Expense table to store all entered expenses, a Rewards table to store all rewards obtained by users, all of which are accessed from the Users table where the users data is recorded for login and registration.


*Security*
Users accounts are authenticated through the use of Firebase Authentication using a unique Gamer ID and password. All collected data is stored and accessed securely through Firebase's built-in security rules. Incorrect login credentials display an error message and prompt the user to retry. Profile pictures are chosen from a pre-defined list in order to prevent users from uploading arbitrary files.


---------------------------------
Use of GitHub and GitHub Actions
---------------------------------
*GitHub*
GitHub was used for version control and collaboration platform for Budget Bee. The full codebase is hosted in a GitHub repository, allowing all team members to work on the project simultaneously without overwriting each other's work. Each team member worked on a separate branch for different features to keep the new code isolated from the main until it was ready to merge. Regular commits were made so that we could keep track of any changes to the code. Before merging a new code from a created branch into the main, a pull request needed to be opened so changes could be reviewed by a chosen team member who could then merge the code to the main afterwards.

*GitHub Actions*
GitHub Actions was used to automate repetitive tasks that run every time code is pushed to the repository. This is known as a CI/CD pipeline (Continuous Integration / Continuous Deployment). Whenever new code is merged onto the main branch, GitHub Actions automatically gets triggered in order to check the code, set up the build environment, build the Android project, run automated tests to make sure that nothing is broken, and report whether the build/tests have passed or failed through the use of green tick icons or red cross icons by the commit name.

--------------
Contributors
--------------
ST10438801-Yamika Govender 
ST10435813-Laiken Diedrick 
ST10440113-Diya Nikhita Singh














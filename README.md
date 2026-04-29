# prog7313-a2-budgetbee
prog7313-a2-budgetbee created by GitHub Classroom

# Budget Bee – PROG7313 Part 2
Budget Bee is a mobile application that helps users track their expenses and manage their spending.

The main idea behind the app is to make it easy to record daily expenses see where money is going and to stay within budget.
We also added a simple rewards system to make the app more interactive and user-friendly

### Add Expense
Where users can add a new expense by entering:
- Amount
- Category
- Date
- Description

This data is saved using a Room Databaseso

### Category Amounts
This screen shows a breakdown of spending

It displays th users:
- Total amount spent
- Spending in each category
- Number of transactions in each category
- The category they spend the most in, which is all calculated in the database.
  
### Rewards System
We added a rewards system to give feedback to the user

where users earn XP based on
- Number of expenses recorded and their pending behaviour

The app also includes:
- A level system, progress bar and an in-app credit score


The app allows users to define a minimum and maximum spending goal in user goals interface

The rewards system checks if the user stays within this range and gives bonus XP if they do
Users are also able to view records by filters and have a choice to download statements

## Database Structure

We used a Room Database with three main tables:
- User where users data is recorded for login and registration
- Cost to store all the data when users create entries for expenses 
- CycleGoal where all costs are recorded 

Each table has a DAO to handle database operations like inserting,retrieving, updataing data


## Video Demonstration
YouTube Link: 


## Contributors

ST10438801-Yamika Govender
ST10435813-Laiken Diedrick
ST10440113-Diya Nikhita Singh

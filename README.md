
# Gym Screen (PDS Project)

- This is made for my IT Course Discipline of PDS (Prática de Desenvolvimentos em Sistemas).
- In this discipline we learn how to work with Java Swing and Windowbuilder.
- On this activity, we were required to build an simple aplication with interaction between screens and that used the components we learned in the classes. After finishing the development we should present it in the class for everyone (That's why methods, classes and variables are in portuguese).
- My objective was to emulate the system of the gym where I workout, which would surpass a lot the minimum expectancies of the activity.

# What I learned building it:
- Data persistence with Files.
- File manipulation with BufferedReader, File and FileReader.
- Java Dictionaries and Timer Tasks.
- More on Java Swing Components and how to make them interactive with the data.

# How it works:
- When launching it, you will be prompted with a Login Screen, which is the only one that actually stops the system.
- You can proceed with the root user (root, root), where you enter the instructor screen. From there, you can see Reports displayed on a Text Area, and create Reports, Users, Exercises, and assign then to a user.
    - Reports work with a priority level since the system is purposely design to hold only 3 reports (For not creating a third simple CRUD), so you write what you want in a TextArea, and give it the priority you want, and it will rearange the order of the reports of equal and lower priority. e.g. A report with level 2 priority will make the older priority 2 become the priority 1, and the old 1 will disappear.
    - Reports can be seen from Instructors and Users displayed on a TextArea that will automatically be updated using TimerTask and Dictionary.
    - Users have a name, an adress, an training experience (which is selected with a Slider), a gender (selected with Radio Buttons), and a Password.
    - Exercises are registered in .txt files, which contain the exercise name and muscular group.
    - Workouts are files with the name being it's user id, that contain 5 lists of exercises.
    - In the workout assigning menu, you can search for the user Id with name, or just typing it's id (which will fill the username field for confirmation), a ComboBox to choose the exercise list and another for searching the Muscular Group of the exercise you are trying to add the list. After filling those fields, you can use three buttons: "Remover" (Remove) which will remove the selected exercise from the exercise list, "Limpar" (Clean) which will make the whole exercise list be reset and "Adicionar" (Add) which will add the selected exercise to the selected list.
- Or you can enter as a user created by the instructor, just type in your id (which is generated when your account is created and just as my gym you will have to memorize it) and your password. From there, you can visualize your workout sheet, update your data, view reports, about the gym, gym rules and contacts.
    - The workout sheet is a Combo Box where you can select the exercise list and a JTable generated with the exercises that are stored there, and their muscular groups.
    - The data update is basically the same as the user create, where you can change any data, excepted your own id (since it's created dinamically as stated before).
    - The report view is the same as the instructor screen.
    - About, rules and gym contacts are just simple TextAreas that contain pre-made text.

# Weaknesses:
- Since I was short on time to finish it, the system has a weak OOP design, lacking SOLID principles and sometimes even looking like Functional Programming. Still, I used this weaknesses to learn even more about OOP searching for how I could avoid those same mistakes in the future.

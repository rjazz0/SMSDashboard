# SMSDashboard
This project reads the SMS messages from the device, uses a "Filter" to categorize the ones that are spam from what they are not (just check the ones that contain the word "spam"). After categorization will insert the messages in the corresponding table in a database. The app looks first in the database to populate the lists of messages and after that checks in the device for the updated list of messages and update the database.

# Tech Debt
- Superclasses to reuse all the duplicated code.
- Communication between Fragments to shared common objects.
- Dependency injection libraries
- 9-Patch image to improve UI
- Use dimens.xml instead of numbers in the xml layout

# SMSDashboard
This project reads the SMS messages from the device, uses a "Filter" to categorize the ones that are spam from what the are not (just check the ones that contains the word "spam"). After categorization will insert the messages in the corresponding table in a database.
The app look first in the database to populate the lists of messages and after that checks in the device for the updated list of messages and update the data base.

# Tech Debt
- Superclases to reuse all the duplicated code.
- Comunication between Fragments to shared common objects.
- Dependency injection libraries
- 9-Patch image to miprove UI
- Use dimens.xml instead of numbers in the xml layout

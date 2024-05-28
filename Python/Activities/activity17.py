# Import pandas
import pandas

# Create a Dictionary that will hold our data
data = {
    "Usernames": ["admin", "Charles", "Khan"],
    "Passwords": ["password", "Charl13", "Kabali"]
}

# Create a DataFrame using that data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("../inputs/sample.csv", index=False)
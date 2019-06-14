import pandas as pd
import numpy as np

data = pd.read_csv(
    'https://raw.githubusercontent.com/petehunt/c4.5-compiler/master/example/tennis.csv',
    usecols=['outlook', 'temp', 'humidity', 'wind', 'play']
)

# We need to get all data
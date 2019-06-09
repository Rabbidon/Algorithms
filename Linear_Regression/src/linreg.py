import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import os

# A simple linear regression on some test data - see https://github.com/jdwittenauer/ipython-notebooks/blob/master/data/ex1data1.txt for the data file


# Cost function
def computeCost(x,y,theta):
    return np.sum(np.power(np.matmul(x,theta)-y,2))/(2*len(x))


# gradient descent function
def gradientDescent(x,y,theta,alpha,iters):

    cost = np.zeros(iters)
    for i in range(iters):
        theta = theta - alpha*(2*(np.transpose(x)@x)@theta - 2*np.transpose(x)@y)
        cost[i] = computeCost(x,y,theta)

    return theta,cost

# data formatting
path = os.getcwd() + "\Data\ex1data1.txt"
data = pd.read_csv(path,header=None, names = ["Population","Profit"])
data.insert(0,"Ones",1)

x = data.iloc[:,0:-1]
y = data.iloc[:,-1:]
x = x.to_numpy()
y = y.to_numpy()

# setting parameters
theta = np.array([0,0])
theta.shape = (2,1)

alpha = 0.0001
iters = 1000

g = gradientDescent(x,y,theta,alpha,iters)

# graphing data
x = np.linspace(data.Population.min(), data.Population.max(), 100)
f = g[0][0] + (g[0][1] * x)

fig, ax = plt.subplots(figsize=(12,8))
ax.plot(x, f, 'r', label='Prediction')
ax.scatter(data.Population, data.Profit, label='Traning Data')
ax.legend(loc=2)
ax.set_xlabel('Population')
ax.set_ylabel('Profit')
ax.set_title('Predicted Profit vs. Population Size')

fig, ax = plt.subplots(figsize=(12,8))
ax.plot(np.arange(iters), g[1], 'r')
ax.set_xlabel('Iterations')
ax.set_ylabel('Cost')
ax.set_title('Error vs. Training Epoch')

plt.show()

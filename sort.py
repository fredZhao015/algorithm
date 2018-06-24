# -*- coding:utf-8 -*-  
# from __future__ import print_function
import plotly
#import plotly.graph_objs as go
from plotly.graph_objs import *
import numpy as np
import csv

 
csvfile = file('sortdata.csv', 'rb')
reader = csv.reader(csvfile)
 
index = 0
dataset = {} 
for line in reader:
	dataset['x'+ str(index)] = line
	index += 1

csvfile.close() 

data_g = []

while index>1:
	index -= 1
	data_g.append(Scatter(
    x = dataset['x0'][1:],
    y = dataset['x'+str(index)][1:],
    name = dataset['x'+str(index)][0],
	))

layout = Layout(title="sort plots", xaxis={'title':'sample size'}, yaxis={'title':'run time(ms)'})
fig = Figure(data=data_g, layout=layout)
plotly.offline.plot(fig)


'''
plotly.offline.plot({
    "data": [go.Scatter(x=[1, 2, 3, 4], y=[4, 3, 2, 1])],
    "layout": go.Layout(title="hello world")
})

x = np.random.randn(2000)
y = np.random.randn(2000)
plotly.offline.iplot([go.Histogram2dContour(x=x, y=y, contours=dict(coloring='heatmap')),
       go.Scatter(x=x, y=y, mode='markers', marker=dict(color='white', size=3, opacity=0.3))], show_link=False)
'''

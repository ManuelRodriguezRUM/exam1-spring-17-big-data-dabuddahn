#Code here
import csv
school_data = sc.textFile("/home/dabuddahn/exam1-spring-17-big-data-dabuddahn/hive/escuelasPR.csv")
student_data = sc.textFile("/home/dabuddahn/exam1-spring-17-big-data-dabuddahn/hive/studentsPR.csv")
student_list=student_data.map(lambda x : [x]).map(lambda x : list(csv.reader(x))[0])
result=student_list.filter(lambda x : x[5] == 'F').filter(lambda x : x[2] == '71381')
result.foreach(print)

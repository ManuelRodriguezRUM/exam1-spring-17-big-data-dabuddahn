#Code here
import csv
school_data = sc.textFile("/home/dabuddahn/exam1-spring-17-big-data-dabuddahn/hive/escuelasPR.csv")
school_list=school_data.map(lambda x: [x]).map(lambda x : list(csv.reader(x))[0])
ponce_city = school_list.filter(lambda x: x[2] == 'Ponce')
cabo_rojo_city = school_list.filter(lambda x: x[2] == 'Cabo Rojo')
dorado_city = school_list.filter(lambda x: x[2] == 'Dorado')
result = ponce_city.union(cabo_rojo_city).union(dorado_city)
result.foreach(print)

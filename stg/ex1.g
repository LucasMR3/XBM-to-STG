
.inputs start Es0 Es1 Es2 
.outputs done 
.graph
p0 start+
start+ p1 
p1 done+
done+ p2 
p2 Es0+
Es0+ p3 
p3 done-
done- p4 
p4 Es2+
Es2+ p5 
p5 done+
done+ p6 
p6 Es1+
Es1+ p7 
p7 done-
done- p8 
p8 Es2-
Es2- p9 
p9 done+
done+ p10 
p10 Es1-
Es1- p11 
p11 done-
done- p12 
p12 Es2+
Es2+ p13 
p13 done+
done+ p14 
p14 start-
start- p15 
p15 done-
done- p16 
p16 Es0-
Es0- p17 
p17 done+
done+ p18 
p18 Es2-
Es2- p19 
p19 done-
done- p0 
.marking {p0} 
.end

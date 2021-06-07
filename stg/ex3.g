.inputs eq prech pmotin 
.outputs ack pmot wen 
.graph
p0 eq+
eq+ p1 
p1 pmot+
pmot+ p2
p2 pmotin+
pmotin+ p3 
p3 wen+
wen+ p4
p4 prech-
prech- p5 
p5 ack+
ack+ p6
p6 eq-
eq- p7 
p7 wen-
wen- p8
p8 pmotin-
pmotin- p9 
p9 pmot-
pmot- p10
p10 prech+
prech+ p11 
p11 ack-
ack- p0
.marking {p0} 
.end
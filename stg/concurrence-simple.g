
.inputs a b 
.outputs x y 
.graph
a+ p1 p2 
b+ p3 p4 
p1 x+
p2 y+
p3 x+
p4 y+
x+ p5 p6
y+ p7 p8
p5 a-
p6 b-
p7 a-
p8 b-
a- p9
b- p10
a- p11
b- p12
p9 x-
p10 y-
p11 x-
p12 y-
x- p13 p14 
y- p15 p16 
p13 a+
p14 b+
p15 a+
p16 b+
.marking{ p13  p14  p15  p16 }
.end

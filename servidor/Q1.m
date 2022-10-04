clear all
clc
syms t a w
f = exp(-t^2)
trans = fourier(f,t,w)
wn = -3.5:0.1:3.5;
trans_num = subs(trans, {w, a}, {wn, 2});
plot(wn, abs(trans_num))
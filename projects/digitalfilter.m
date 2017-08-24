Waveform = importdata('WaveformX_improved.csv');
 
t = Waveform.data(:,2);
x = Waveform.data(:,3);
 
windowSize = 100;
a = 1;
b = (1/windowSize)*ones(1,windowSize);
 
y = filter(b, a, x);
 
plot(t,x,'g')
hold on
plot(t,y,'b')
legend('Input Data','Filtered Data')
xlabel('Time (sec)');
ylabel('Voltage (v)');
title('Voltage vs. Time for X Direction Oscillations'); 
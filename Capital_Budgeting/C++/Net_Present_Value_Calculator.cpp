#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

double calculateNPV(int numYears, vector<double> cashFlows, double initialInvestment, double discountRate) {
    vector<double> presentValues(numYears);
    
    // Convert discount rate from percentage to decimal
    discountRate /= 100;
    
    for (int i = 0; i < numYears; i++) {
        presentValues[i] = cashFlows[i] / pow(1 + discountRate, i + 1);
    }
    
    double npv = 0;
    for (double presentValue : presentValues) {
        npv += presentValue;
    }
    npv -= initialInvestment;
    return npv;
}

int main() {
    int numYears;
    cout << "Enter the number of years: ";
    cin >> numYears;
    
    vector<double> cashFlows(numYears);
    for (int i = 0; i < numYears; i++) {
        cout << "Enter cash flow for Year " << i + 1 << ": ";
        cin >> cashFlows[i];
    }
    
    double initialInvestment;
    cout << "Enter initial investment: ";
    cin >> initialInvestment;
    
    double discountRate;
    cout << "Enter discount rate (%): ";
    cin >> discountRate;
    
    // Calculate NPV
    double npv = calculateNPV(numYears, cashFlows, initialInvestment, discountRate);
    
    // Print the result
    cout << "The Net Present Value (NPV) of the project is: " << npv << endl;

    return 0;
}

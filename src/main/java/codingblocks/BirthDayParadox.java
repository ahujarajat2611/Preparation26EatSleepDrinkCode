package codingblocks;

/**
 * Created by hadoop on 30/9/17.
 */
public class BirthDayParadox {
}

/*

Made with by


Made with by

#include <iostream>
using namespace std;


int main() {
    //Compute the number of ppl such that

    float num = 365;
    float denom = 365;

    // p denotes the prob of some ppl having birthday on same date
    float p = 1;

    //n denotes the number of people needed
    int n = 0;

    // p becomes less than 0.5 because we are starting from 1
    while(p>0.5){
        p = p*(num)/denom;
        num--;
        n++;
        cout<<"Probability is "<<p<<" and "<<" no of people are "<<n<<endl;
    }

    return 0;
}

 */
/*
#include <iostream>
using namespace std;

int main() {

        //Numbers from 1 to 49
        //Choose a subset of 6 Numbers

        int a[] = {1,2,4,5,6,7,8,10,12};
        int n = sizeof(a)/sizeof(int);

        for(int i=0;i<n-5;i++){

            for(int j=i+1;j<n-4;j++){

                for(int k=j+1;k<n-3;k++){

                    for(int l=k+1;l<n-2;l++){

                        for(int m = l+1;m<n-1;m++){

                            for(int o= m+1;o<n;o++){

                                cout<<a[i]<<","<<a[j]<<","<<a[k]<<","<<a[l]<<","<<a[m]<<","<<a[o]<<endl;
                            }

                        }

                    }
                }
            }
        }
        return 0;


}

 */
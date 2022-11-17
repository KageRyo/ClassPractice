// CPE 一星精選題 22
// UVA11461 Square Numbers

#include<iostream>
#include<cmath>
using namespace std;
int main(){
	int n1,n2,ans,temp;
	while(cin>>n1>>n2){				// 輸入數字1 及數字2
		if(n1==0)break;				// 若數字 1 為 0 break
		ans=0;						// ans 歸零
		for(int i=n1;i<=n2;i++){
			temp=(int)sqrt(i);		// 取餘數
			if(temp*temp==i)ans++;	// 平方
		}
		cout<<ans<<endl;			//印出結果
	}
}

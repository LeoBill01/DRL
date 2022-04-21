

package com.salaryshow.community;

import java.util.Scanner;

/**
 * PageRank算法
 * 本文算法是通过邻接矩阵表示图，而不是邻接表
 * @author DELL
 *
 */
public class cuode_PageRank {

      private final static int ITTIME=10;
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m;
            int[][] numb;
            System.out.println("开始....输入N");
            while (scanner.hasNext()) {
                  m = scanner.nextInt();
                  numb = new int[m][m];
                  for (int i = 0; i < m; i++) {
                        //System.out.println("输入行值：");
                        for (int j = 0; j < m; j++) {
                              numb[i][j] = scanner.nextInt();
                        }
                  }

                  for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                              System.out.println(numb[i][j]);
                        }
                  }


                  // 声明当前PageRank估值
                  double[] nowRank = new double[m];
                  // 声明最终估计的结果
                  double[] resultRank = new double[m];
                  for (int i = 0; i < m; i++)
                        nowRank[i] = 1.0 / m;
                  boolean flag = true;// 表示当前最终网页链接估计收敛
                  double r = 0.15;// 考虑其他可能0 1 0 1 0 0 1 0 0 0 0 1 1 0 0 0
                  int sum=0;//表示迭代次数；
                  while (flag) {
                        if(sum== cuode_PageRank.ITTIME)
                              break;
                        sum++;
                        System.out.println("第"+sum+"轮迭代开始----");
                        for (int i = 0; i < m; i++)
                              resultRank[i] = r / m;
                        // 对与任意一个节点，找一个和其相邻的节点集合
                        for (int i = 0; i < m; i++) {
                              int count = 0;// 统计和节点i相连的节点个数
                              for (int j = 0; j < m; j++) {
                                    if (numb[i][j] != 0) {
                                          count++;
                                    }
                              }
                              if (count > 0) {
                                    for (int j = 0; j < m; j++) {
                                          if (numb[i][j] != 0) {double value=(1 - r)*nowRank[i]/ count;
                                                resultRank[j] +=value;
                                          }
                                    }
                              } else {
                                    for(int j=0;j<m;j++){
                                          resultRank[j]+=(1-r)*nowRank[i]/m;
                                    }
                              }
                              //nowRank=resultRank;-----fuck you
                              for(int j=0;j<m;j++){
                                    nowRank[j]=resultRank[j];
                              }
                              System.out.println("遍历完一个节点------------------------------------------------");
                              //-------
                        }
                        for(int i=0;i<m;i++){
                              System.out.print(";  节点"+i+" 概率:"+resultRank[i]);
                        }
                        System.out.println("\n-------------------------------------");
                  }

            }
      }
}




//自己写的 没成功
//      public double pageRank(int n,int temp[][]) {
//
//            double Pr_A=  0.333;
//            double Pr_B=  0.333;
//            double Pr_C=  0.333;
//
//
//
//            double sum=0;
//            double count=0;
//            double degree_A=2;
//            double degree_B=1;
//            double degree_C=1;
//
//
////            for (int i=0;i<3;++i)
////            {
////                  for (int j = 0; j < 3;++j)
////                  {
////                        if(temp[i][j]==1)
////                        {
////                              count=count+1;
////                        }
////                  }
////
////                  if(i==0)
////                  {
////                        degree_A=count;
////                         count=0;
////                  }
////                  if(i==1)
////                  {
////                        degree_B=count;
////                         count=0;
////                  }
////                  if(i==2)
////                  {
////                        degree_C=count;
////                        count=0;
////                  }
////
////            }
//
//for (int k=0;k<n;++k) {
//      for (int i = 0; i < 3; ++i) {
//            for (int j = 0; j < 3; ++j) {
//                  if (temp[i][j] == 1) {
//                        if ( j == 0) {
//                              sum = sum + Pr_A / degree_A;
//                        }
//                        if (j == 1) {
//                              sum = sum + Pr_B / degree_B;
//                        }
//                        if (j == 2) {
//                              sum = sum + Pr_C / degree_C;
//                        }
//
//                  }
//
//                  if (i == 0) {
//                        Pr_A = ((1 - 0.85) / 3 + 0.85 * sum);
//                        sum=0;
//                  }
//                  if (i == 1) {
//                        Pr_B = ((1 - 0.85) / 3 + 0.85 * sum);
//                        sum=0;
//                  }
//                  if (i == 2) {
//                        Pr_C = ((1 - 0.85) / 3 + 0.85 * sum);
//                        sum=0;
//                  }
//
//
//            }
//
//
//
//
//      }
//}
//
//            return Pr_A;
//
//      }
//
//
//
//      public static void main(String[] args) {
//
//            cuode_PageRank p=new cuode_PageRank();
//
//            int[][] temp = new int[][]{{0,1,0},{1,0,1},{1,0,0}};
//            System.out.println(p.pageRank(1,temp));
//      }
//
//}

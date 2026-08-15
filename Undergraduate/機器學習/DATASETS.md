# 外部資料集

本課程練習使用的外部資料集不放在 repository 中。執行相關程式前，請先依下列說明下載到程式所在的資料夾；資料來源的條款與授權以原網站為準。

## Titanic

資料來源： [Kaggle Titanic: Machine Learning from Disaster](https://www.kaggle.com/competitions/titanic/data)

從 Kaggle 的 **Data** 頁面下載：

- `train.csv`，放到 `week15/train.csv`
- `gender_submission.csv`（若要執行提交範例），放到 `week15/gender_submission.csv`

`week18-final-practice/DecisionTree.py` 與 `SVM.py` 預期的檔名是
`titanic_train.csv`。可將同一份 `train.csv` 複製或重新命名為：

```text
week18-final-practice/titanic_train.csv
```

## Boston Housing

`week18-final-practice/LR.py` 與 `MLR.py` 使用舊版 Boston Housing CSV 格式，預期檔名為：

```text
week18-final-practice/boston_house_prices.csv
```

Boston Housing 已被新版 scikit-learn 移除；[scikit-learn 1.0 的說明](https://scikit-learn.org/1.0/modules/generated/sklearn.datasets.load_boston.html) 同時說明資料集的倫理疑慮與原始資料來源。若要重現這些歷史課堂練習，請依該說明取得資料並自行轉成程式所需的 CSV 格式；不要將資料重新提交到本 repository。

這些程式僅供課堂練習與歷史重現使用；外部資料的使用條款、著作權與其他限制不因本 repository 公開而改變。

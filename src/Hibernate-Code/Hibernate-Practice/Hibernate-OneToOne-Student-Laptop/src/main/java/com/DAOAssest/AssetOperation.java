package com.DAOAssest;

import java.io.IOException;

public interface AssetOperation {
    void registerAsset() throws IOException;
    void displayAsset();
    void deleteAsset();
    void updateAsset();
    void displayAssetById();
}

// Generated by view binder compiler. Do not edit!
package com.example.kream.kotlin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.example.kream.kotlin.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMyPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final TextView buyingMore;

  @NonNull
  public final View buyingSeparator;

  @NonNull
  public final ChipGroup chipGroup;

  @NonNull
  public final TextView earnRate;

  @NonNull
  public final TextView gainLoss;

  @NonNull
  public final TextView marketValue;

  @NonNull
  public final TextView marketValueCnt;

  @NonNull
  public final TextView myBio;

  @NonNull
  public final ConstraintLayout myBuyingCard;

  @NonNull
  public final TextView myBuyingCurrentCnt;

  @NonNull
  public final TextView myBuyingHistoryCnt;

  @NonNull
  public final TextView myBuyingPendingCnt;

  @NonNull
  public final TextView myBuyingTotalCnt;

  @NonNull
  public final ImageView myCameraIcon;

  @NonNull
  public final ImageView myEditProfileBtn;

  @NonNull
  public final TextView myMembershipLevel;

  @NonNull
  public final TextView myName;

  @NonNull
  public final TextView myNickname;

  @NonNull
  public final TextView myPoints;

  @NonNull
  public final Chip myProfileChip;

  @NonNull
  public final ImageView myProfilePic;

  @NonNull
  public final ConstraintLayout mySellingCard;

  @NonNull
  public final TextView mySellingCurrentCnt;

  @NonNull
  public final TextView mySellingHistoryCnt;

  @NonNull
  public final TextView mySellingPendingCnt;

  @NonNull
  public final TextView mySellingTotalCnt;

  @NonNull
  public final ImageView mySettingIcon;

  @NonNull
  public final Chip myShoppingChip;

  @NonNull
  public final TextView myTvMembershipLevel;

  @NonNull
  public final TextView myTvPoints;

  @NonNull
  public final TextView myTvWishlist;

  @NonNull
  public final TextView myWishlistCnt;

  @NonNull
  public final TextView portfolioMore;

  @NonNull
  public final TextView sellingMore;

  @NonNull
  public final View sellingSeparator;

  @NonNull
  public final View separatorBelowMyPortfolio;

  @NonNull
  public final View separatorBelowName;

  @NonNull
  public final View separatorBelowPinBar;

  @NonNull
  public final View separatorBelowPortfolioContainer;

  @NonNull
  public final View separatorBelowSellingCard;

  @NonNull
  public final ConstraintLayout topBar;

  @NonNull
  public final TextView totalPurchaseAmount;

  @NonNull
  public final TextView tvBuying;

  @NonNull
  public final TextView tvBuyingCurrent;

  @NonNull
  public final TextView tvBuyingHistory;

  @NonNull
  public final TextView tvBuyingPending;

  @NonNull
  public final TextView tvBuyingTotal;

  @NonNull
  public final TextView tvEarnRate;

  @NonNull
  public final TextView tvGainLoss;

  @NonNull
  public final TextView tvMarketValue;

  @NonNull
  public final TextView tvMyItems;

  @NonNull
  public final TextView tvPortfolio;

  @NonNull
  public final TextView tvSelling;

  @NonNull
  public final TextView tvSellingCurrent;

  @NonNull
  public final TextView tvSellingHistory;

  @NonNull
  public final TextView tvSellingPending;

  @NonNull
  public final TextView tvSellingTotal;

  @NonNull
  public final TextView tvTotalPurchase;

  @NonNull
  public final CoordinatorLayout wrapper;

  private FragmentMyPageBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppBarLayout appBarLayout, @NonNull TextView buyingMore,
      @NonNull View buyingSeparator, @NonNull ChipGroup chipGroup, @NonNull TextView earnRate,
      @NonNull TextView gainLoss, @NonNull TextView marketValue, @NonNull TextView marketValueCnt,
      @NonNull TextView myBio, @NonNull ConstraintLayout myBuyingCard,
      @NonNull TextView myBuyingCurrentCnt, @NonNull TextView myBuyingHistoryCnt,
      @NonNull TextView myBuyingPendingCnt, @NonNull TextView myBuyingTotalCnt,
      @NonNull ImageView myCameraIcon, @NonNull ImageView myEditProfileBtn,
      @NonNull TextView myMembershipLevel, @NonNull TextView myName, @NonNull TextView myNickname,
      @NonNull TextView myPoints, @NonNull Chip myProfileChip, @NonNull ImageView myProfilePic,
      @NonNull ConstraintLayout mySellingCard, @NonNull TextView mySellingCurrentCnt,
      @NonNull TextView mySellingHistoryCnt, @NonNull TextView mySellingPendingCnt,
      @NonNull TextView mySellingTotalCnt, @NonNull ImageView mySettingIcon,
      @NonNull Chip myShoppingChip, @NonNull TextView myTvMembershipLevel,
      @NonNull TextView myTvPoints, @NonNull TextView myTvWishlist, @NonNull TextView myWishlistCnt,
      @NonNull TextView portfolioMore, @NonNull TextView sellingMore,
      @NonNull View sellingSeparator, @NonNull View separatorBelowMyPortfolio,
      @NonNull View separatorBelowName, @NonNull View separatorBelowPinBar,
      @NonNull View separatorBelowPortfolioContainer, @NonNull View separatorBelowSellingCard,
      @NonNull ConstraintLayout topBar, @NonNull TextView totalPurchaseAmount,
      @NonNull TextView tvBuying, @NonNull TextView tvBuyingCurrent,
      @NonNull TextView tvBuyingHistory, @NonNull TextView tvBuyingPending,
      @NonNull TextView tvBuyingTotal, @NonNull TextView tvEarnRate, @NonNull TextView tvGainLoss,
      @NonNull TextView tvMarketValue, @NonNull TextView tvMyItems, @NonNull TextView tvPortfolio,
      @NonNull TextView tvSelling, @NonNull TextView tvSellingCurrent,
      @NonNull TextView tvSellingHistory, @NonNull TextView tvSellingPending,
      @NonNull TextView tvSellingTotal, @NonNull TextView tvTotalPurchase,
      @NonNull CoordinatorLayout wrapper) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.buyingMore = buyingMore;
    this.buyingSeparator = buyingSeparator;
    this.chipGroup = chipGroup;
    this.earnRate = earnRate;
    this.gainLoss = gainLoss;
    this.marketValue = marketValue;
    this.marketValueCnt = marketValueCnt;
    this.myBio = myBio;
    this.myBuyingCard = myBuyingCard;
    this.myBuyingCurrentCnt = myBuyingCurrentCnt;
    this.myBuyingHistoryCnt = myBuyingHistoryCnt;
    this.myBuyingPendingCnt = myBuyingPendingCnt;
    this.myBuyingTotalCnt = myBuyingTotalCnt;
    this.myCameraIcon = myCameraIcon;
    this.myEditProfileBtn = myEditProfileBtn;
    this.myMembershipLevel = myMembershipLevel;
    this.myName = myName;
    this.myNickname = myNickname;
    this.myPoints = myPoints;
    this.myProfileChip = myProfileChip;
    this.myProfilePic = myProfilePic;
    this.mySellingCard = mySellingCard;
    this.mySellingCurrentCnt = mySellingCurrentCnt;
    this.mySellingHistoryCnt = mySellingHistoryCnt;
    this.mySellingPendingCnt = mySellingPendingCnt;
    this.mySellingTotalCnt = mySellingTotalCnt;
    this.mySettingIcon = mySettingIcon;
    this.myShoppingChip = myShoppingChip;
    this.myTvMembershipLevel = myTvMembershipLevel;
    this.myTvPoints = myTvPoints;
    this.myTvWishlist = myTvWishlist;
    this.myWishlistCnt = myWishlistCnt;
    this.portfolioMore = portfolioMore;
    this.sellingMore = sellingMore;
    this.sellingSeparator = sellingSeparator;
    this.separatorBelowMyPortfolio = separatorBelowMyPortfolio;
    this.separatorBelowName = separatorBelowName;
    this.separatorBelowPinBar = separatorBelowPinBar;
    this.separatorBelowPortfolioContainer = separatorBelowPortfolioContainer;
    this.separatorBelowSellingCard = separatorBelowSellingCard;
    this.topBar = topBar;
    this.totalPurchaseAmount = totalPurchaseAmount;
    this.tvBuying = tvBuying;
    this.tvBuyingCurrent = tvBuyingCurrent;
    this.tvBuyingHistory = tvBuyingHistory;
    this.tvBuyingPending = tvBuyingPending;
    this.tvBuyingTotal = tvBuyingTotal;
    this.tvEarnRate = tvEarnRate;
    this.tvGainLoss = tvGainLoss;
    this.tvMarketValue = tvMarketValue;
    this.tvMyItems = tvMyItems;
    this.tvPortfolio = tvPortfolio;
    this.tvSelling = tvSelling;
    this.tvSellingCurrent = tvSellingCurrent;
    this.tvSellingHistory = tvSellingHistory;
    this.tvSellingPending = tvSellingPending;
    this.tvSellingTotal = tvSellingTotal;
    this.tvTotalPurchase = tvTotalPurchase;
    this.wrapper = wrapper;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = rootView.findViewById(id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.buying_more;
      TextView buyingMore = rootView.findViewById(id);
      if (buyingMore == null) {
        break missingId;
      }

      id = R.id.buying_separator;
      View buyingSeparator = rootView.findViewById(id);
      if (buyingSeparator == null) {
        break missingId;
      }

      id = R.id.chip_group;
      ChipGroup chipGroup = rootView.findViewById(id);
      if (chipGroup == null) {
        break missingId;
      }

      id = R.id.earn_rate;
      TextView earnRate = rootView.findViewById(id);
      if (earnRate == null) {
        break missingId;
      }

      id = R.id.gain_loss;
      TextView gainLoss = rootView.findViewById(id);
      if (gainLoss == null) {
        break missingId;
      }

      id = R.id.market_value;
      TextView marketValue = rootView.findViewById(id);
      if (marketValue == null) {
        break missingId;
      }

      id = R.id.market_value_cnt;
      TextView marketValueCnt = rootView.findViewById(id);
      if (marketValueCnt == null) {
        break missingId;
      }

      id = R.id.my_bio;
      TextView myBio = rootView.findViewById(id);
      if (myBio == null) {
        break missingId;
      }

      id = R.id.my_buying_card;
      ConstraintLayout myBuyingCard = rootView.findViewById(id);
      if (myBuyingCard == null) {
        break missingId;
      }

      id = R.id.my_buying_current_cnt;
      TextView myBuyingCurrentCnt = rootView.findViewById(id);
      if (myBuyingCurrentCnt == null) {
        break missingId;
      }

      id = R.id.my_buying_history_cnt;
      TextView myBuyingHistoryCnt = rootView.findViewById(id);
      if (myBuyingHistoryCnt == null) {
        break missingId;
      }

      id = R.id.my_buying_pending_cnt;
      TextView myBuyingPendingCnt = rootView.findViewById(id);
      if (myBuyingPendingCnt == null) {
        break missingId;
      }

      id = R.id.my_buying_total_cnt;
      TextView myBuyingTotalCnt = rootView.findViewById(id);
      if (myBuyingTotalCnt == null) {
        break missingId;
      }

      id = R.id.my_camera_icon;
      ImageView myCameraIcon = rootView.findViewById(id);
      if (myCameraIcon == null) {
        break missingId;
      }

      id = R.id.my_edit_profile_btn;
      ImageView myEditProfileBtn = rootView.findViewById(id);
      if (myEditProfileBtn == null) {
        break missingId;
      }

      id = R.id.my_membership_level;
      TextView myMembershipLevel = rootView.findViewById(id);
      if (myMembershipLevel == null) {
        break missingId;
      }

      id = R.id.my_name;
      TextView myName = rootView.findViewById(id);
      if (myName == null) {
        break missingId;
      }

      id = R.id.my_nickname;
      TextView myNickname = rootView.findViewById(id);
      if (myNickname == null) {
        break missingId;
      }

      id = R.id.my_points;
      TextView myPoints = rootView.findViewById(id);
      if (myPoints == null) {
        break missingId;
      }

      id = R.id.my_profile_chip;
      Chip myProfileChip = rootView.findViewById(id);
      if (myProfileChip == null) {
        break missingId;
      }

      id = R.id.my_profile_pic;
      ImageView myProfilePic = rootView.findViewById(id);
      if (myProfilePic == null) {
        break missingId;
      }

      id = R.id.my_selling_card;
      ConstraintLayout mySellingCard = rootView.findViewById(id);
      if (mySellingCard == null) {
        break missingId;
      }

      id = R.id.my_selling_current_cnt;
      TextView mySellingCurrentCnt = rootView.findViewById(id);
      if (mySellingCurrentCnt == null) {
        break missingId;
      }

      id = R.id.my_selling_history_cnt;
      TextView mySellingHistoryCnt = rootView.findViewById(id);
      if (mySellingHistoryCnt == null) {
        break missingId;
      }

      id = R.id.my_selling_pending_cnt;
      TextView mySellingPendingCnt = rootView.findViewById(id);
      if (mySellingPendingCnt == null) {
        break missingId;
      }

      id = R.id.my_selling_total_cnt;
      TextView mySellingTotalCnt = rootView.findViewById(id);
      if (mySellingTotalCnt == null) {
        break missingId;
      }

      id = R.id.my_setting_icon;
      ImageView mySettingIcon = rootView.findViewById(id);
      if (mySettingIcon == null) {
        break missingId;
      }

      id = R.id.my_shopping_chip;
      Chip myShoppingChip = rootView.findViewById(id);
      if (myShoppingChip == null) {
        break missingId;
      }

      id = R.id.my_tv_membership_level;
      TextView myTvMembershipLevel = rootView.findViewById(id);
      if (myTvMembershipLevel == null) {
        break missingId;
      }

      id = R.id.my_tv_points;
      TextView myTvPoints = rootView.findViewById(id);
      if (myTvPoints == null) {
        break missingId;
      }

      id = R.id.my_tv_wishlist;
      TextView myTvWishlist = rootView.findViewById(id);
      if (myTvWishlist == null) {
        break missingId;
      }

      id = R.id.my_wishlist_cnt;
      TextView myWishlistCnt = rootView.findViewById(id);
      if (myWishlistCnt == null) {
        break missingId;
      }

      id = R.id.portfolio_more;
      TextView portfolioMore = rootView.findViewById(id);
      if (portfolioMore == null) {
        break missingId;
      }

      id = R.id.selling_more;
      TextView sellingMore = rootView.findViewById(id);
      if (sellingMore == null) {
        break missingId;
      }

      id = R.id.selling_separator;
      View sellingSeparator = rootView.findViewById(id);
      if (sellingSeparator == null) {
        break missingId;
      }

      id = R.id.separator_below_my_portfolio;
      View separatorBelowMyPortfolio = rootView.findViewById(id);
      if (separatorBelowMyPortfolio == null) {
        break missingId;
      }

      id = R.id.separator_below_name;
      View separatorBelowName = rootView.findViewById(id);
      if (separatorBelowName == null) {
        break missingId;
      }

      id = R.id.separator_below_pin_bar;
      View separatorBelowPinBar = rootView.findViewById(id);
      if (separatorBelowPinBar == null) {
        break missingId;
      }

      id = R.id.separator_below_portfolio_container;
      View separatorBelowPortfolioContainer = rootView.findViewById(id);
      if (separatorBelowPortfolioContainer == null) {
        break missingId;
      }

      id = R.id.separator_below_selling_card;
      View separatorBelowSellingCard = rootView.findViewById(id);
      if (separatorBelowSellingCard == null) {
        break missingId;
      }

      id = R.id.top_bar;
      ConstraintLayout topBar = rootView.findViewById(id);
      if (topBar == null) {
        break missingId;
      }

      id = R.id.total_purchase_amount;
      TextView totalPurchaseAmount = rootView.findViewById(id);
      if (totalPurchaseAmount == null) {
        break missingId;
      }

      id = R.id.tv_buying;
      TextView tvBuying = rootView.findViewById(id);
      if (tvBuying == null) {
        break missingId;
      }

      id = R.id.tv_buying_current;
      TextView tvBuyingCurrent = rootView.findViewById(id);
      if (tvBuyingCurrent == null) {
        break missingId;
      }

      id = R.id.tv_buying_history;
      TextView tvBuyingHistory = rootView.findViewById(id);
      if (tvBuyingHistory == null) {
        break missingId;
      }

      id = R.id.tv_buying_pending;
      TextView tvBuyingPending = rootView.findViewById(id);
      if (tvBuyingPending == null) {
        break missingId;
      }

      id = R.id.tv_buying_total;
      TextView tvBuyingTotal = rootView.findViewById(id);
      if (tvBuyingTotal == null) {
        break missingId;
      }

      id = R.id.tv_earn_rate;
      TextView tvEarnRate = rootView.findViewById(id);
      if (tvEarnRate == null) {
        break missingId;
      }

      id = R.id.tv_gain_loss;
      TextView tvGainLoss = rootView.findViewById(id);
      if (tvGainLoss == null) {
        break missingId;
      }

      id = R.id.tv_market_value;
      TextView tvMarketValue = rootView.findViewById(id);
      if (tvMarketValue == null) {
        break missingId;
      }

      id = R.id.tv_my_items;
      TextView tvMyItems = rootView.findViewById(id);
      if (tvMyItems == null) {
        break missingId;
      }

      id = R.id.tv_portfolio;
      TextView tvPortfolio = rootView.findViewById(id);
      if (tvPortfolio == null) {
        break missingId;
      }

      id = R.id.tv_selling;
      TextView tvSelling = rootView.findViewById(id);
      if (tvSelling == null) {
        break missingId;
      }

      id = R.id.tv_selling_current;
      TextView tvSellingCurrent = rootView.findViewById(id);
      if (tvSellingCurrent == null) {
        break missingId;
      }

      id = R.id.tv_selling_history;
      TextView tvSellingHistory = rootView.findViewById(id);
      if (tvSellingHistory == null) {
        break missingId;
      }

      id = R.id.tv_selling_pending;
      TextView tvSellingPending = rootView.findViewById(id);
      if (tvSellingPending == null) {
        break missingId;
      }

      id = R.id.tv_selling_total;
      TextView tvSellingTotal = rootView.findViewById(id);
      if (tvSellingTotal == null) {
        break missingId;
      }

      id = R.id.tv_total_purchase;
      TextView tvTotalPurchase = rootView.findViewById(id);
      if (tvTotalPurchase == null) {
        break missingId;
      }

      id = R.id.wrapper;
      CoordinatorLayout wrapper = rootView.findViewById(id);
      if (wrapper == null) {
        break missingId;
      }

      return new FragmentMyPageBinding((ConstraintLayout) rootView, appBarLayout, buyingMore,
          buyingSeparator, chipGroup, earnRate, gainLoss, marketValue, marketValueCnt, myBio,
          myBuyingCard, myBuyingCurrentCnt, myBuyingHistoryCnt, myBuyingPendingCnt,
          myBuyingTotalCnt, myCameraIcon, myEditProfileBtn, myMembershipLevel, myName, myNickname,
          myPoints, myProfileChip, myProfilePic, mySellingCard, mySellingCurrentCnt,
          mySellingHistoryCnt, mySellingPendingCnt, mySellingTotalCnt, mySettingIcon,
          myShoppingChip, myTvMembershipLevel, myTvPoints, myTvWishlist, myWishlistCnt,
          portfolioMore, sellingMore, sellingSeparator, separatorBelowMyPortfolio,
          separatorBelowName, separatorBelowPinBar, separatorBelowPortfolioContainer,
          separatorBelowSellingCard, topBar, totalPurchaseAmount, tvBuying, tvBuyingCurrent,
          tvBuyingHistory, tvBuyingPending, tvBuyingTotal, tvEarnRate, tvGainLoss, tvMarketValue,
          tvMyItems, tvPortfolio, tvSelling, tvSellingCurrent, tvSellingHistory, tvSellingPending,
          tvSellingTotal, tvTotalPurchase, wrapper);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

from factorcalculator import calculate_percentages
import seaborn as sns
import numpy as np
import matplotlib.colors as colors
import matplotlib.pyplot as plt

S = .5

def heatmap(df):
    clrs = sns.color_palette("RdBu_r", 50)
    plt.figure(figsize=(S * len(df), S * len(df)))  # Should be a parameter

    # log_norm = SymLogNorm(vmin=0, linthresh=100, vmax=400)

    bounds = .5 * np.logspace(start=0, stop=2, num=50, base=2)
    norm = colors.BoundaryNorm(boundaries=bounds, ncolors=50)

    ax = sns.heatmap(data=df, annot=True, fmt="2.0%", norm=norm,
                     # center=100,
                     cbar_kws={"ticks":[.5,1,2]},
                     cmap=clrs, linewidths=.5, vmin=.25, vmax=4)
    plt.xticks(np.arange(5) + .5, ('100', '1k', '10k', '100k', '1M'))
    plt.tight_layout()
    return plt
"""

Script for calculating the factor and percentages in relation to a
norm

"""


E_FACTOR = 5

def calculate_percentages(mean, error, norm, eFactor=E_FACTOR):

    n_mean = mean.loc[norm]
    n_error = error.loc[norm]

    mean = mean / n_mean
    overlap = is_overlapping(mean - eFactor * error, mean + eFactor * error,
                             n_mean - eFactor * n_error, n_mean + eFactor * n_error)
    mean[overlap] = 1
    return mean


def is_overlapping(x1, x2, y1, y2):
    return (x1 <= y2) & (y1 <= x2)


def calculate_factor(mean, error, norm, eFactor=E_FACTOR):
    n_mean = mean.loc[norm]
    n_error = error.loc[norm]

    speedup = mean < n_mean
    slowdown = mean > n_mean

    mean[speedup] = n_mean / mean
    mean[slowdown] = - mean / n_mean

    overlap = is_overlapping(mean - eFactor * error, mean + eFactor * error,
                             n_mean - eFactor * n_error, n_mean + eFactor * n_error)
    mean[overlap] = 0
    return mean
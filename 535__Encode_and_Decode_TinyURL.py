import random
import string

class Codec:
    def __init__(self):
        self.url_pair = {}

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL."""
        # Get a set of characters that will make up the suffix
        suffix_set = string.ascii_letters + string.digits

        # Make a tinyurl template
        tiny_url = "http://tinyurl.com/".join(random.choice(suffix_set) for _ in range(6))
        
        # Store the pair in the dictionary
        self.url_pair[tiny_url] = longUrl

        return tiny_url

    def decode(self, shortUrl):
        """Decodes the shortened URL to its original URL."""
        # Return the value from a given key from the dictionary
        return self.url_pair.get(shortUrl)
